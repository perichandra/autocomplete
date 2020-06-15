package com.perichandra.autocomplete.dictionary;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class AutoCompDictionary {
    private static final Set<String> dictionary;

    static {
        List<String> stringList = Arrays.asList("tap", "tarsal", "tarsale", "tarsalgia", "tarsectomy", "tarsi", "tarski", "tart", "tartar");
        dictionary = new TreeSet<>(stringList);
    }

    public List<String> getWordsStartingWith(String givenWord) {
        if (StringUtils.isEmpty(givenWord)) {
            return Collections.emptyList();
        }
        return dictionary.stream().filter(s -> s.startsWith(givenWord)).collect(Collectors.toList());
    }
}
