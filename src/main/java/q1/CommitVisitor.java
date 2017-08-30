
package q1;

import org.repodriller.domain.Commit;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.scm.SCMRepository;

/**
 *
 * @author Jmallone
 */
public class CommitVisitor implements org.repodriller.scm.CommitVisitor {

    @Override
    public void process(SCMRepository scmr, Commit commit, PersistenceMechanism pm) {
        
        pm.write(
                scmr.getLastDir(),
                commit.getHash(), 
                commit.getAuthor().getName(), 
                commit.getAuthor().getEmail()
        );
        
    }

    @Override
    public String name() {
        return "JUBILEU COMMITADO";
    }
    
}
