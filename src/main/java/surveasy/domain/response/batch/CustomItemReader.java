package surveasy.domain.response.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

public class CustomItemReader<T> implements ItemReader<T> {

    private List<T> items;

    public CustomItemReader(List<T> items) {
        this.items = items;
    }

    @Override
    public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(!items.isEmpty()) {
            return items.remove(0);
        }

        return null;    // chunk 끝
    }
}
