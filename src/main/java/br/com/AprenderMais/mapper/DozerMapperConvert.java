package br.com.AprenderMais.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapperConvert {
	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <Origin, Destination> Destination parseObject(Origin o, Class<Destination> d) {
		return mapper.map(o, d);
	}
	
	public static <Origin, Destination> List<Destination> parseListObjects(List<Origin> o, Class<Destination> d){
		List<Destination> destinationObjs = new ArrayList<Destination>();
		for (Origin origin : o) {
			destinationObjs.add(mapper.map(origin, d));
		}
		return destinationObjs;
	}
}
