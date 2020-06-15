package com.perichandra.autocomplete.dictionary;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class AutoCompDictionary {
    private static final Set<String> dictionary;

    static {
        List<String> stringList = Arrays.asList("tree", "tarsectomy", "tarsalgia", "tap", "tarsal", "tarsale", "tarsi", "tarski", "tart", "tartar");
        dictionary = new TreeSet<>(stringList);
    }

    public List<String> queryTheDict(String givenWord) {
        return dictionary.stream().filter(s -> s.startsWith(givenWord)).collect(Collectors.toList());
    }

    public List<String> getWordsStartingWith(String givenWord) {
        if (StringUtils.isEmpty(givenWord)) {
            return Collections.emptyList();
        }
        return queryTheDict(givenWord);
    }


    public List<String> getWordsStartingWith(String givenWord, int limit) {
        if (StringUtils.isEmpty(givenWord)) {
            return Collections.emptyList();
        }
        return  queryTheDict(givenWord).stream().limit(limit).collect(Collectors.toList());
    }
}
