package br.com.erudio.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O,D> D parseObject (O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O,D> List<D> parseListObjects (List<O> origin, Class<D> destination){
        List<D> destinations = new ArrayList<>();

        for (O o : origin){
            destinations.add(mapper.map(o, destination));
        }
        return destinations;
    }

}
