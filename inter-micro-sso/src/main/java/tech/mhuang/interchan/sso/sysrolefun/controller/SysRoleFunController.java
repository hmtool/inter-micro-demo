
package tech.mhuang.interchan.sso.sysrolefun.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.mhuang.ext.interchan.core.controller.BaseController;
import tech.mhuang.ext.interchan.core.local.GlobalHeaderThreadLocal;
import tech.mhuang.ext.interchan.protocol.Result;
import tech.mhuang.interchan.protocol.sso.sysfunrole.SysRoleFunAddDTO;
import tech.mhuang.interchan.protocol.sso.sysfunrole.SysRoleFunDTO;
import tech.mhuang.interchan.protocol.sso.sysfunrole.SysRoleFunTreeDTO;
import tech.mhuang.interchan.protocol.sso.sysfunrole.SysRoleFunTreeVO;
import tech.mhuang.interchan.protocol.sso.sysfunrole.SysRoleFunVO;
import tech.mhuang.ext.spring.util.DataUtil;
import tech.mhuang.interchan.sso.sysrolefun.service.ISysRoleFunService;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName: SysRoleFunController
 * @Description:系统角色功能
 * @author: admin
 * @date: 2017年7月20日 下午6:48:48
 */
@RestController
@Api(value = "系统角色功能管理", tags = "角色功能")
@RequestMapping("/sy/sysrolefun")
public class SysRoleFunController extends BaseController {

    @Autowired
    private ISysRoleFunService sysRoleFunService;

    @ApiOperation(value = "保存角色功能信息", notes = "保存")
    @PostMapping(value = "/setRoleFun")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysRoleFunAddDTO", value = "角色功能对象,多个funid用逗号隔开", required = true, paramType = "body", dataType = "SysRoleFunAddDTO"),
    })
    public Result<?> setRoleFun(@RequestBody SysRoleFunAddDTO sysRoleFunAddDTO) {
        sysRoleFunService.saveRoleFun(sysRoleFunAddDTO, GlobalHeaderThreadLocal.getOrException().getUserId());
        return Result.ok();
    }


    @ApiOperation(value = "树形结构查询角色权限信息", notes = "查询")
    @GetMapping(value = "/queryRoleFunTree")
    public Result<List<SysRoleFunTreeVO>> queryRoleFunTree(
            @RequestParam(required = false) String roleid) {
        GlobalHeaderThreadLocal.getOrException();
        List<SysRoleFunTreeDTO> roleFunVos = this.sysRoleFunService.queryRoleFunTree(roleid);
        List<SysRoleFunTreeVO> treeVos = this.structFunTree(roleFunVos);
        return (Result<List<SysRoleFunTreeVO>>) Result.ok(treeVos);
    }


    /**
     * @param roleFunVos
     * @return List<SysRoleFunTreeVo>
     * @Title: structFunTree
     * @Description: 组装功能树
     */
    private List<SysRoleFunTreeVO> structFunTree(List<SysRoleFunTreeDTO> roleFunVos) {
        List<SysRoleFunTreeVO> vos = new CopyOnWriteArrayList<>();
        if (!CollectionUtils.isEmpty(roleFunVos)) {
            roleFunVos.parallelStream().forEach((data) -> {
                if ("TOP".equals(data.getParentid())) {
                    SysRoleFunTreeVO vo = DataUtil.copyTo(data, SysRoleFunTreeVO.class);
                    vos.add(vo);
                    List<SysRoleFunTreeVO> children = this.getRoleFunChildren(data, roleFunVos);
                    if (!CollectionUtils.isEmpty(children)) {
                        children.sort(Comparator.comparingInt(SysRoleFunTreeVO::getOrderval));
                    }
                    vo.setChildren(children);
                }
            });
        }
        if (!CollectionUtils.isEmpty(vos)) {
            vos.sort(Comparator.comparingInt(SysRoleFunTreeVO::getOrderval));
        }
        return vos;
    }


    /**
     * @param current
     * @param roleFunVos
     * @return List<SysRoleFunTreeVo>
     * @Title: getRoleFunChildren
     * @Description: 获取当前角色权限的子
     */
    private List<SysRoleFunTreeVO> getRoleFunChildren(SysRoleFunTreeDTO current, List<SysRoleFunTreeDTO> roleFunVos) {
        List<SysRoleFunTreeVO> vos = new CopyOnWriteArrayList<>();
        roleFunVos.parallelStream().forEach((data) -> {
            if (current.getFunid().equals(data.getParentid())) {
                SysRoleFunTreeVO vo = DataUtil.copyTo(data, SysRoleFunTreeVO.class);
                vos.add(vo);
                vo.setChildren(this.getRoleFunChildren(data, roleFunVos));
            }
        });
        return vos;
    }


    @ApiOperation(value = "查询角色功能信息", notes = "查询")
    @GetMapping(value = "/queryRoleFun")
    public Result<List<SysRoleFunVO>> queryRoleFun(
            @RequestParam String roleid) {
        GlobalHeaderThreadLocal.getOrException();
        List<SysRoleFunDTO> dtos = this.sysRoleFunService.queryRoleFun(roleid);
        List<SysRoleFunVO> roleFunVos = DataUtil.copyTo(dtos, SysRoleFunVO.class);
        return (Result<List<SysRoleFunVO>>) Result.ok(roleFunVos);
    }
}
