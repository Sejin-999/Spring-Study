package hello.demo.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance(); //싱글톤이기 때문에 다른 클래스에서 만드는게 안됨 그래서 불러와서 쓰는거 new 하지말라는거

    @AfterEach
    void afterEach(){
        memberRepository.claerStore();
    }
    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member savemember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(savemember.getId());
        Assertions.assertThat(findMember).isEqualTo(savemember);
    }
    @Test
    void findAll(){
        //given
        Member test1 = new Member("test1", 22);
        Member test2 = new Member("test2", 25);

        memberRepository.save(test1);
        memberRepository.save(test2);
        //when
        List<Member> result = memberRepository.findAll();
        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
