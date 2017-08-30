
package q1;

import org.repodriller.RepoDriller;
import org.repodriller.RepositoryMining;
import org.repodriller.Study;
import org.repodriller.filter.range.Commits;
import org.repodriller.persistence.csv.CSVFile;
import org.repodriller.scm.GitRemoteRepository;
import org.repodriller.scm.GitRepository;

/**
 *
 * @author JMallone
 */
public class Q1Study implements Study {
    
    public static void main(String[] args) {
        new RepoDriller().start(new Q1Study());
    }
     
    public void execute() {
        new RepositoryMining()
                .in(GitRepository.allProjectsIn("/home/todos/alunos/cm/a1858351/minicurso/Projetos"))
                //.in(GitRemoteRepository.hostedOn("https://github.com/Jmallone/com.clavierdev.git").buildAsSCMRepository())
                .through(Commits.all())
                .process(new CommitVisitor(), new CSVFile("/home/todos/alunos/cm/a1858351/minicurso/Relatorios/q1_Michel.csv"))
                .mine();
    }
    
}
