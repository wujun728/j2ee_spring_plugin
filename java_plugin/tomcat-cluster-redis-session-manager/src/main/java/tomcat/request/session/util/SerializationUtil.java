package tomcat.request.session.util;

import org.apache.catalina.util.CustomObjectInputStream;
import tomcat.request.session.model.Session;
import tomcat.request.session.model.SessionMetadata;
import tomcat.request.session.model.SingleSignOnEntry;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/** author: Ranjith Manickam @ 12 Jul' 2018 */
public class SerializationUtil {

    private ClassLoader loader;

    /** To set class loader. */
    public void setClassLoader(ClassLoader loader) {
        this.loader = loader;
    }

    /** To get session attributes hash code. */
    public byte[] getSessionAttributesHashCode(Session session) throws IOException {
        byte[] serialized;
        Map<String, Object> attributes = new HashMap<>();

        for (Enumeration<String> enumerator = session.getAttributeNames();
             enumerator.hasMoreElements(); ) {
            String key = enumerator.nextElement();
            attributes.put(key, session.getAttribute(key));
        }

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bos))) {
            oos.writeUnshared(attributes);
            oos.flush();
            serialized = bos.toByteArray();
        }

        MessageDigest digester;
        try {
            digester = MessageDigest.getInstance("MD5");
        } catch (Exception ex) {
            throw new RuntimeException("Unable to get MessageDigest instance for MD5", ex);
        }
        return digester.digest(serialized);
    }

    /** To serialize session object. */
    public byte[] serializeSessionData(Session session, SessionMetadata metadata) throws IOException {
        byte[] serialized;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bos))) {
            oos.writeObject(metadata);
            session.writeObjectData(oos);
            oos.flush();
            serialized = bos.toByteArray();
        }
        return serialized;
    }

    /** To de-serialize session object. */
    public void deserializeSessionData(byte[] data, Session session, SessionMetadata metadata)
            throws IOException, ClassNotFoundException {
        try (BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(data));
             ObjectInputStream ois = new CustomObjectInputStream(bis, this.loader)) {
            SessionMetadata serializedMetadata = (SessionMetadata) ois.readObject();
            metadata.copyFieldsFrom(serializedMetadata);
            session.readObjectData(ois);
        }
    }

    /** To serialize single-sign-on entry. */
    public byte[] serializeSingleSignOnEntry(SingleSignOnEntry entry) throws IOException {
        byte[] serialized;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bos))) {
            entry.writeObjectData(oos);
            oos.flush();
            serialized = bos.toByteArray();
        }
        return serialized;
    }

    /** To de-serialize single-sign-on entry. */
    public void deserializeSingleSignOnEntry(byte[] data, SingleSignOnEntry entry)
            throws IOException, ClassNotFoundException {
        try (BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(data));
             ObjectInputStream ois = new CustomObjectInputStream(bis, this.loader)) {
            entry.readObjectData(ois);
        }
    }
}
