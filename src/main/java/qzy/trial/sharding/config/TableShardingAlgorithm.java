package qzy.trial.sharding.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 分表算法
 */
public final class TableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Long> {

    /**
     * where id=1
     * @param tableNames
     * @param shardingValue
     * @return
     */
    public String doEqualSharding(final Collection<String> tableNames, final ShardingValue<Long> shardingValue) {
        for (String table : tableNames) {
            if (table.endsWith(shardingValue.getValue() % 2 + "")) {
                return table;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * where id in (1,2)
     * @param tableNames
     * @param shardingValue
     * @return
     */
    public Collection<String> doInSharding(final Collection<String> tableNames, final ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableNames.size());
        for (Long value : shardingValue.getValues()) {
            for (String tableName : tableNames) {
                if (tableName.endsWith(value % 2 + "")) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }

    /**
     * where id between 1 and 3
     * @param tableNames
     * @param shardingValue
     * @return
     */
    public Collection<String> doBetweenSharding(final Collection<String> tableNames, final ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableNames.size());
        Range<Long> range = shardingValue.getValueRange();
        for (Long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String each : tableNames) {
                if (each.endsWith(i % 2 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}