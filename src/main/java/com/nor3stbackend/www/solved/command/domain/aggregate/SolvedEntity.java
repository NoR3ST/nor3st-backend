package com.nor3stbackend.www.solved.command.domain.aggregate;

import com.nor3stbackend.www.member.command.domain.aggregate.MemberEntity;
import com.nor3stbackend.www.problem.command.domain.aggregate.ProblemEntity;
import com.nor3stbackend.www.solved.command.domain.enumType.ProblemType;
import com.nor3stbackend.www.solved.command.domain.enumType.SolvedEnum;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "solved")
@Entity
@Getter
public class SolvedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long solvedId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private ProblemEntity problemEntity;

    private String audioUrl;

    private Integer solvedScore;

    private LocalDate solvedDate;

    @Enumerated(EnumType.STRING)
    private SolvedEnum isSolved;

    @Enumerated(EnumType.STRING)
    private ProblemType problemType;

    public SolvedEntity() {
    }

    // 회원 가입 문제 생성
    public SolvedEntity(MemberEntity memberEntity, ProblemEntity problemEntity, ProblemType problemType) {
        this.memberEntity = memberEntity;
        this.problemEntity = problemEntity;
        this.solvedDate = LocalDate.now();
        this.solvedScore = 0;
        this.isSolved = SolvedEnum.UNSOLVED;
        this.problemType = problemType;
    }

    public SolvedEntity(MemberEntity memberEntity, String audioUrl) {
        this.memberEntity = memberEntity;
        this.audioUrl = audioUrl;
        this.solvedDate = LocalDate.now();
        this.isSolved = SolvedEnum.UNSOLVED;
    }

    // 리스닝 문제 생성 생성자
    public void speakingSolved(String audioUrl, SolvedEnum isSolved, int solvedScore) {
        this.audioUrl = audioUrl;
        this.isSolved = isSolved;
        this.solvedScore = solvedScore;
    }

    public void listeningSolved(SolvedEnum isSolved, int solvedScore) {
        this.isSolved = isSolved;
        this.solvedScore = solvedScore;
    }
}
