package pl.portfolio.Planner_App.Model;

import org.modelmapper.ModelMapper;

import java.util.List;

public class MyModelMapper extends ModelMapper {
    private MyModelMapper() {
        super();
        this.getConfiguration().setAmbiguityIgnored(true);
    }

    public static MyModelMapper getInstance() {
        return new MyModelMapper();
    }

    public <D, S> List<D> mapAll(List<S> source, Class<D> destinationType) {
        return source.stream()
                .map(element -> this.map(element, destinationType))
                .collect(java.util.stream.Collectors.toList());
    }
}
