
package q2;

import org.repodriller.RepoDriller;
import org.repodriller.RepositoryMining;
import org.repodriller.Study;
import org.repodriller.filter.commit.OnlyInMainBranch;
import org.repodriller.filter.range.Commits;
import org.repodriller.persistence.csv.CSVFile;
import org.repodriller.scm.GitRepository;

/**
 *
 * @author Jmallone
 */
public class Q2Study implements Study{
    
    public static void main(String[] args) {
        new RepoDriller().start(new Q2Study());
    }
    
    @Override
    public void execute() {
        new RepositoryMining()
                .in(GitRepository.singleProject("/home/todos/alunos/cm/a1858351/minicurso/Projetos/notepad-plus-plus"))
                .through(Commits.all())
                .filters(
                        new OnlyInMainBranch()
                )
                .process( new BugVisitor(), new CSVFile("/home/todos/alunos/cm/a1858351/minicurso/Relatorios/bug.csv"))
                .mine();
    }
    
}
