package com.vijay.springbootlearning.configuration;

import org.springframework.data.convert.DefaultTypeMapper;
import org.springframework.data.convert.SimpleTypeInformationMapper;
import org.springframework.data.couchbase.core.convert.CouchbaseTypeMapper;
import org.springframework.data.couchbase.core.convert.DefaultCouchbaseTypeMapper;
import org.springframework.data.couchbase.core.mapping.CouchbaseDocument;
import org.springframework.data.mapping.Alias;
import org.springframework.data.util.TypeInformation;

import java.util.Collections;

public class CustomTypeBasedCouchbaseTypeMapper extends DefaultTypeMapper<CouchbaseDocument> implements CouchbaseTypeMapper {
    private final String typeKey;

    public CustomTypeBasedCouchbaseTypeMapper(final String typeKey) {
        super(new DefaultCouchbaseTypeMapper.CouchbaseDocumentTypeAliasAccessor(typeKey), Collections.singletonList(new SimpleTypeInformationMapper()));
        this.typeKey = typeKey;
    }

    @Override
    public String getTypeKey() {
        return typeKey;
    }

    @Override
    public Alias getTypeAlias(TypeInformation<?> typeInformation) {
        return Alias.ofNullable(null);
    }


}
