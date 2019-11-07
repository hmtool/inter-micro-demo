package tech.mhuang.interchan.sso.sysuser.mapper;

import tech.mhuang.ext.interchan.core.mapper.BaseMapper;
import tech.mhuang.interchan.sso.sysuser.entity.SysUserRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: SysUserRecordMapper
 * @Description:资金方历史信息mapper
 * @author: mhuang
 * @date: 2017年7月19日 上午10:11:32
 */
@Mapper
public interface SysUserRecordMapper extends BaseMapper<SysUserRecord, String> {
}