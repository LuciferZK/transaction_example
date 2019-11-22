package com.lucifer.log.mapper;

import com.lucifer.pojo.LogInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lucifer
 */
public interface LogMapper {

    /**
     * 新增
     * @param logInfo
     * @return
     */
    int insertLogInfo(LogInfo logInfo);

    /**
     * 批量新增
     * @param logInfoList
     * @return
     */
    int insertBatchLogs(@Param("logInfoList") List<LogInfo> logInfoList);
}
