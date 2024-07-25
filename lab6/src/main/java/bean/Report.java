package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "Report.favoriteByYear", procedureName = "spFavoriteByYear", parameters = {
        @StoredProcedureParameter(name = "year", type = Integer.class) }, resultClasses = { Report.class })
})
@Entity
public class Report {
    @Id
    String group;
    Long like;
    Date newest;
    Date oldest;

    public Report(String group, Long like, Date newest, Date oldest) {
        super();
        this.group = group;
        this.like = like;
        this.newest = newest;
        this.oldest = oldest;
    }
    
    public Report() {
		
	}

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    public Date getNewest() {
        return newest;
    }

    public void setNewest(Date newest) {
        this.newest = newest;
    }

    public Date getOldest() {
        return oldest;
    }

    public void setOldest(Date oldest) {
        this.oldest = oldest;
    }
}
