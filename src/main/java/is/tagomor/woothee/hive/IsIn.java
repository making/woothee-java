package is.tagomor.woothee.hive;

import java.util.Map;
import java.util.List;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import is.tagomor.woothee.DataSet;

@Description(name="is_in",
             value="_FUNC_ return Boolan: map's ['category'] is equals to one of LIST or not",
             extended="WHERE _FUNC_(parse_agent(user_agent_string), array('pc', 'mobilephone', 'smartphone', 'appliance')) AND ...")
public final class IsIn extends UDF {
  public Boolean evaluate(final Map<String,String> m, final List<String> categories) {
    String targetCategory = m.get(DataSet.ATTRIBUTE_CATEGORY);
    for (String c : categories) {
      if (targetCategory.equals(c))
        return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
}
