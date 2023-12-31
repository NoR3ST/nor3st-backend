package com.nor3stbackend.www.solved.query.infra.mapper;

import com.nor3stbackend.www.solved.query.application.vo.DailyTaskVO;
import com.nor3stbackend.www.solved.query.application.vo.TaskProgressPercentageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Mapper
public interface SolvedMapper {
    List<DailyTaskVO> getMyDailyTask(Long memberId);

    double getCompanyDailySolvedRate(Long companyId);

    double getCompanyDailySolvedAvgScore(Long companyId);

    int getCompanyDailySolvedEmployeeCount(Long companyId);

    List<String> getMyDailyTaskListeningWrongVietList(Long problemId);

    TaskProgressPercentageVO getCompanyTaskPercentageDaily(Long companyId);

    TaskProgressPercentageVO getCompanyTaskPercentageWeekly(Long companyId);

    TaskProgressPercentageVO getCompanyTaskPercentageMonthly(Long companyId);
}
