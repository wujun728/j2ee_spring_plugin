package tomcat.request.session.model;

import org.apache.catalina.Manager;
import org.apache.catalina.session.StandardSession;
import tomcat.request.session.redis.SessionManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Principal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/** author: Ranjith Manickam @ 12 Jul' 2018 */
public class Session extends StandardSession {

    private static final long serialVersionUID = -6056744304016869278L;

    private Boolean dirty;
    private Map<String, Object> changedAttributes;

    private static Boolean manualDirtyTrackingSupportEnabled = false;
    private static String manualDirtyTrackingAttributeKey = "__changed__";

    public Session(Manager manager) {
        super(manager);
        resetDirtyTracking();
    }

    /** To reset dirty tracking. */
    public void resetDirtyTracking() {
        this.changedAttributes = new HashMap<>();
        this.dirty = false;
    }

    /** To set manual dirty tracking support enabled. */
    public static void setManualDirtyTrackingSupportEnabled(boolean enabled) {
        manualDirtyTrackingSupportEnabled = enabled;
    }

    /** To set manual dirty tracking attribute key. */
    public static void setManualDirtyTrackingAttributeKey(String key) {
        manualDirtyTrackingAttributeKey = key;
    }

    /** Returns dirty check. */
    public Boolean isDirty() {
        return this.dirty || !this.changedAttributes.isEmpty();
    }

    /** To get changed attributes. */
    public Map<String, Object> getChangedAttributes() {
        return this.changedAttributes;
    }

    /** {@inheritDoc} */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /** {@inheritDoc} */
    @Override
    public void setAttribute(String key, Object value) {
        if (manualDirtyTrackingSupportEnabled && manualDirtyTrackingAttributeKey.equals(key)) {
            this.dirty = true;
            return;
        }

        Object oldValue = getAttribute(key);
        super.setAttribute(key, value);

        if ((value != null || oldValue != null)
                && (value == null && oldValue != null || oldValue == null && value != null || !value.getClass().isInstance(oldValue) || !value.equals(oldValue))) {
            if (this.manager instanceof SessionManager && ((SessionManager) this.manager).getSaveOnChange()) {
                ((SessionManager) this.manager).save(this, true);
            } else {
                this.changedAttributes.put(key, value);
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public Object getAttribute(String name) {
        return super.getAttribute(name);
    }

    /** {@inheritDoc} */
    @Override
    public Enumeration<String> getAttributeNames() {
        return super.getAttributeNames();
    }

    /** {@inheritDoc} */
    @Override
    public void removeAttribute(String name) {
        super.removeAttribute(name);
        if (this.manager instanceof SessionManager && ((SessionManager) this.manager).getSaveOnChange()) {
            ((SessionManager) this.manager).save(this, true);
        } else {
            this.dirty = true;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setPrincipal(Principal principal) {
        super.setPrincipal(principal);
        this.dirty = true;
    }

    /** {@inheritDoc} */
    @Override
    public void writeObjectData(ObjectOutputStream out) throws IOException {
        super.writeObjectData(out);
        out.writeLong(this.getCreationTime());
    }

    /** {@inheritDoc} */
    @Override
    public void readObjectData(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readObjectData(in);
        this.setCreationTime(in.readLong());
    }

    /** {@inheritDoc} */
    @Override
    public void invalidate() {
        super.invalidate();
    }
}
