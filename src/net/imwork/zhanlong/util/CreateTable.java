package net.imwork.zhanlong.util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.util.EnumSet;

/**
 * @author 展龙
 */
public class CreateTable
{
    public static void main(String[] args)
    {
        //hibernate5中的schemaExport与之前版本中的用法有所不同，具体用法如下:
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport export = new SchemaExport().setFormat(true);
        export.create(EnumSet.of(TargetType.DATABASE),metadata);
    }
}
