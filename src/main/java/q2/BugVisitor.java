
package q2;

import org.repodriller.domain.Commit;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.scm.CommitVisitor;
import org.repodriller.scm.SCMRepository;


/**
 *
 * @author Jmallone
 */
public class BugVisitor implements CommitVisitor{

    @Override
    public void process(SCMRepository scmr, Commit commit, PersistenceMechanism pm) {
        
        boolean temBug = commit.getMsg().toLowerCase().contains("bug");
        int numArq = commit.getModifications().size();
                
        if(temBug){
            
            pm.write( commit.getHash(), numArq);
        }
        
        
    }

    @Override
    public String name() {
        return "BUG-Visitor";
    }
    
}
