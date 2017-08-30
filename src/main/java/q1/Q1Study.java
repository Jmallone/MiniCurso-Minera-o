
package q1;

import org.repodriller.RepoDriller;
import org.repodriller.RepositoryMining;
import org.repodriller.Study;
import org.repodriller.filter.range.Commits;
import org.repodriller.persistence.csv.CSVFile;
import org.repodriller.scm.GitRepository;

/**
 *
 * @author JMallone
 */
public class Q1Study implements Study {
    
    public static void main(String[] args) {
        new RepoDriller().start(new Q1Study());
    }
    
    @Override
    public void execute() {
        new RepositoryMining()
                .in(GitRepository.singleProject("/home/todos/alunos/cm/a1858351/minicurso/melonJS"))
                .through(Commits.all())
                .process(new CommitVisitor(), new CSVFile("/home/todos/alunos/cm/a1858351/minicurso/Relatorios/q1.csv"))
                .mine();
    }
    
}
