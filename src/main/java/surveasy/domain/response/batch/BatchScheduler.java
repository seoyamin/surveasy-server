package surveasy.domain.response.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class BatchScheduler {

    private final JobLauncher jobLauncher;
    private final AggregationJobConfig aggregationJobConfig;

    @Scheduled(cron = "0 10 4 1,11,21 * ?")
    public void batchScheduler() throws Exception {
        jobLauncher.run(aggregationJobConfig.aggregationJob(),
                new JobParametersBuilder()
                        .addLong("time", new Date().getTime())
                        .addLocalDate("now", LocalDate.now())
                        .toJobParameters()
        );
    }
}
