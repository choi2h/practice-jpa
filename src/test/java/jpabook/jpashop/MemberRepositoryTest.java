package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    /*
    Test에 있으면 test했던 내용은 데이터를 롤백
    log : Rolled back transaction for test:
     */
    @Test
    @Transactional
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUserName("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId().equals(member.getId()));
        Assertions.assertThat(findMember.getUserName().equals(member.getUserName()));

        /*
        true응답 -> 같은 트랜잭션 내에서 바이트 값(식별자)이 같으면 같은 엔티티로 인식
         */
        Assertions.assertThat(findMember.equals(member));
    }

}