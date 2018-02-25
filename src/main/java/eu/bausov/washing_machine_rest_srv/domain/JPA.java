package eu.bausov.washing_machine_rest_srv.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by GreenNun on 25/02/2018.
 */
@MappedSuperclass
public abstract class JPA {

    private Long id;
    private Date version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "version")
    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        Long id = getId();
        return (id == null ? super.hashCode() : id.intValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().isInstance(obj)) {
            return false;
        }
        if (hashCode() != obj.hashCode()) {
            return false;
        }
        Long id = getId();
        Long oid = ((JPA) obj).getId();
        return id != null && oid != null && id.equals(oid);
    }
}
