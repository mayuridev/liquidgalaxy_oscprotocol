package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({Scope.LIBRARY_GROUP_PREFIX})
public class MethodCallsLogger {
    private Map<String, Integer> mCalledMethods = new HashMap();

    @RestrictTo({Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(String name, int type) {
        Integer nullableMask = (Integer) this.mCalledMethods.get(name);
        int mask = nullableMask != null ? nullableMask.intValue() : 0;
        boolean wasCalled = (mask & type) != 0;
        this.mCalledMethods.put(name, Integer.valueOf(mask | type));
        if (!wasCalled) {
            return true;
        }
        return false;
    }
}
