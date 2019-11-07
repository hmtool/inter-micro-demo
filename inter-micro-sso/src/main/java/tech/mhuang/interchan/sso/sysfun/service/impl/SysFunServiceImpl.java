package tech.mhuang.interchan.sso.sysfun.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import tech.mhuang.core.id.BaseIdeable;
import tech.mhuang.core.util.StringUtil;
import tech.mhuang.ext.interchan.core.exception.BusinessException;
import tech.mhuang.ext.interchan.core.service.impl.BaseServiceImpl;
import tech.mhuang.ext.interchan.protocol.InsertInto;
import tech.mhuang.ext.interchan.protocol.Result;
import tech.mhuang.ext.interchan.protocol.data.Page;
import tech.mhuang.ext.interchan.protocol.data.PageVO;
import tech.mhuang.interchan.protocol.sso.sysfun.SysFunAddDTO;
import tech.mhuang.interchan.protocol.sso.sysfun.SysFunDTO;
import tech.mhuang.interchan.protocol.sso.sysfun.SysFunModDTO;
import tech.mhuang.interchan.protocol.sso.sysfun.SysFunPageQueryDTO;
import tech.mhuang.interchan.protocol.sso.sysfun.SysFunQueryDTO;
import tech.mhuang.interchan.protocol.sso.sysfun.SysFunTreeQueryDTO;
import tech.mhuang.interchan.protocol.sso.sysfun.SysFunVO;
import tech.mhuang.interchan.protocol.sso.sysfunvisturl.SyChanmgfunVistUrlmAddDTO;
import tech.mhuang.ext.spring.util.DataUtil;
import tech.mhuang.interchan.sso.sysfun.entity.SysFun;
import tech.mhuang.interchan.sso.sysfun.mapper.SysFunMapper;
import tech.mhuang.interchan.sso.sysfun.service.ISysFunService;
import tech.mhuang.interchan.sso.sysfunvisturl.service.ISyChanmgfunVistUrlService;
import tech.mhuang.interchan.sso.sysrolefun.service.ISysRoleFunService;

/**
 * 
 * @ClassName: SysFunServiceImpl
 * @Description:系统功能权限服务
 * @author: 张小虎
 * @date: 2017年7月19日 上午10:10:04
 */
@Service("sysFunService")
@Transactional(readOnly = true)
public class SysFunServiceImpl extends BaseServiceImpl<SysFun, String> implements ISysFunService {

	@Autowired
	private SysFunMapper sysFunMapper;

	@Autowired
	private Environment environment;

	@Autowired
	private ISysRoleFunService sysRoleFunService;
	
	@Autowired
	private ISyChanmgfunVistUrlService syChanmgfunVistUrlService;

	@Autowired
	private BaseIdeable<String> ideable;

	public void setMapper(SysFunMapper sysFunMapper) {
		this.setBaseMapper(sysFunMapper);
	}


	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveFun(SysFunAddDTO sysFunAddDTO, String userId) {
		// 检查代号是否存在
		SysFun fun = this.sysFunMapper.getById(sysFunAddDTO.getFunid());
		if (fun != null) {// 存在功能权限代码
			throw new BusinessException(Result.SYS_RESULT_FAILD, this.environment.getProperty("sysfunid_exists"));
		}
		fun = DataUtil.copyTo(sysFunAddDTO, SysFun.class);
		if ("TOP".equals(fun.getFunid())) {
			throw new BusinessException(Result.SYS_RESULT_FAILD, this.environment.getProperty("sysfunid_is_error"));
		}
		fun.setOperateTime(new Date());
		fun.setOperateUser(userId);
		if (StringUtil.isNotBlank(fun.getParentid()) && !"TOP".equals(fun.getParentid())) {
			SysFun parent = this.getById(fun.getParentid());
			if (parent == null) {
				throw new BusinessException(Result.SYS_RESULT_FAILD,
						this.environment.getProperty("sysfunparent_not_exists"));
			}
			fun.setLayid(parent.getLayid() + 1);
		} else {
			fun.setParentid("TOP");
			fun.setLayid(1);
		}
		this.sysFunMapper.save(fun);
		InsertInto<String> into = new InsertInto<>();
		into.setReqNo(ideable.generateId());
		into.setId(fun.getFunid());
		into.setStatus(InsertInto.ADD);
		into.setUserId(userId);
		this.sysFunMapper.insertInto(into);
		if(StringUtil.isNotBlank(sysFunAddDTO.getPowerPaths())){
			  final String funid = fun.getFunid();
			  List<String> urls = new ArrayList<>();
			  List<SyChanmgfunVistUrlmAddDTO> dtos = 
					Arrays.asList(sysFunAddDTO.getPowerPaths().split(",")).parallelStream().map(value->{
					SyChanmgfunVistUrlmAddDTO dto = new SyChanmgfunVistUrlmAddDTO();
					dto.setFunid(funid);
					dto.setUrl(value);
					return dto;
			}).filter(value->{
				if(StringUtil.isNotBlank(value.getUrl())
						&& !urls.contains(value.getUrl())){
					urls.add(value.getUrl());
					return true;
				}else{
					return false;
				}
			}).collect(Collectors.toList());
			this.syChanmgfunVistUrlService.insertPowersUrl(dtos,userId,into.getReqNo());
		}
	}

	/**
	 * <p>
	 * Title: updateFun
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param userId
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateFun(SysFunModDTO sysFunModDTO, String userId) {
		// 检查代号是否存在
		SysFun fun = this.sysFunMapper.getById(sysFunModDTO.getFunid());
		if (fun == null) {// 存在不存在功能权限代码
			throw new BusinessException(Result.SYS_RESULT_FAILD, this.environment.getProperty("sysfun_not_exists"));
		}
		DataUtil.copyTo(sysFunModDTO, fun);
		fun.setOperateTime(new Date());
		fun.setOperateUser(userId);
		if (StringUtil.isNotBlank(sysFunModDTO.getParentid()) && !"TOP".equals(fun.getParentid())) {
			SysFun parent = this.getById(sysFunModDTO.getParentid());
			if (parent == null) {
				throw new BusinessException(Result.SYS_RESULT_FAILD,
						this.environment.getProperty("sysfunparent_not_exists"));
			}
			fun.setLayid(parent.getLayid() + 1);
		} else {
			fun.setParentid("TOP");
			fun.setLayid(1);
		}

		this.sysFunMapper.updateById(fun);
		InsertInto<String> into = new InsertInto<>();
		into.setReqNo(ideable.generateId());
		into.setId(fun.getFunid());
		into.setStatus(InsertInto.UPDATE);
		into.setUserId(userId);
		this.sysFunMapper.insertInto(into);
		this.syChanmgfunVistUrlService.insertHByAuth(fun.getFunid(),userId,InsertInto.DELETE,ideable.generateId());
		this.syChanmgfunVistUrlService.deleteByAuth(fun.getFunid());
		if(StringUtil.isNotBlank(sysFunModDTO.getPowerPaths())){
			  final String funid = fun.getFunid();
			  List<String> urls = new ArrayList<>();
			  List<SyChanmgfunVistUrlmAddDTO> dtos = 
					  Arrays.asList(sysFunModDTO.getPowerPaths().split(",")).parallelStream().map(value->{
				SyChanmgfunVistUrlmAddDTO dto = new SyChanmgfunVistUrlmAddDTO();
				dto.setFunid(funid);
				dto.setUrl(value);
				return dto;
			}).filter(value->{
				if(StringUtil.isNotBlank(value.getUrl())
						&& !urls.contains(value.getUrl())){
					urls.add(value.getUrl());
					return true;
				}else{
					return false;
				}
			}).collect(Collectors.toList());
			this.syChanmgfunVistUrlService.insertPowersUrl(dtos,userId,into.getReqNo());
		}
	}


	@Override
	public PageVO<SysFunVO> queryFunByPage(SysFunPageQueryDTO dto) {
		Page<SysFun> page = new Page<>();
		SysFun funm = DataUtil.copyTo(dto, SysFun.class);
		page.setRecord(funm);
		page.setRows(dto.getRows());
		page.setStart((dto.getStart() - 1) * dto.getRows());
		PageVO<SysFunVO> pageVo = new PageVO<>();
		List<SysFun> sysFuns = sysFunMapper.page(page);
		pageVo.setResult(DataUtil.copyTo(sysFuns, SysFunVO.class));
		pageVo.setTotalSize(this.sysFunMapper.pageCount(page));
		return pageVo;
	}

	@Override
	public SysFunQueryDTO queryFun(String funid, boolean nullException) {
		SysFun fun = sysFunMapper.getById(funid);
		SysFunQueryDTO dto = null;
		if (fun == null) {
			if (nullException) {
				throw new BusinessException(Result.SYS_RESULT_FAILD, this.environment.getProperty("sysfun_not_exists"));
			}
		} else {
			dto = new SysFunQueryDTO();
			if (StringUtil.isNotBlank(fun.getParentid())) {
				try {
					dto.setParentName(this.getById(fun.getParentid()).getFundesc());
				} catch (Exception e) {
				}
			}
			DataUtil.copyTo(fun, dto);
		}
		return dto;
	}


	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void deleteFun(String funid, String userId) {
		List<SysFun> childFuns = this.sysFunMapper.queryFunByParent(funid);
		List<String> ids = new ArrayList<>();
		ids.add(funid);
		List<String> queryIds = new ArrayList<>();
		while (!CollectionUtils.isEmpty(childFuns)) {
			childFuns.parallelStream().forEachOrdered((data) -> {
				if (!ids.contains(data.getFunid())) {
					ids.add(data.getFunid());
					queryIds.add(data.getFunid());
				}
			});
			childFuns = null;
			if (!CollectionUtils.isEmpty(queryIds)) {
				childFuns = this.sysFunMapper.queryFunByParents(queryIds);
			}
			queryIds.clear();
		}
		InsertInto<List<String>> into = new InsertInto<>();
		into.setReqNo(ideable.generateId());
		into.setId(ids);
		into.setStatus(InsertInto.DELETE);
		into.setUserId(userId);
		into.setOpDate(new Date());
		this.sysFunMapper.insertIntos(into);
		this.sysFunMapper.deleteFunByIds(ids);
		this.sysRoleFunService.deleteRoleFunByFuns(ids, userId);
		this.syChanmgfunVistUrlService.deleteByFunsIds(ids,userId,InsertInto.DELETE,into.getReqNo());
	}

	@Override
	public List<SysFunVO> queryFunTree(SysFunTreeQueryDTO dto) {
		SysFun funm = DataUtil.copyTo(dto, SysFun.class);
		List<SysFunDTO> funs = this.sysFunMapper.queryFunTree(funm);
		return DataUtil.copyTo(funs, SysFunVO.class);
	}
}