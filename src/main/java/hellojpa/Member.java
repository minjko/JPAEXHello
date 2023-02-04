package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Member")  // H2db에 있는 테이블 이름을 써준다. 그러면 쿼리가 그쪽으로 들어간다
public class Member {
    @Id
    @Column(name="id")  // H2db에 있는 테이블의 컬럼명을 써준다. 그러면 쿼리가 그쪽으로 들어간다
    private Long id;
    private String name;

    public Member() { }
    public Member(Long id, String name) {
            this.id = id;
            this.name = name;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}