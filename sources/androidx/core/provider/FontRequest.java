package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import androidx.core.util.Preconditions;
import java.util.List;

public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    public FontRequest(@NonNull String providerAuthority, @NonNull String providerPackage, @NonNull String query, @NonNull List<List<byte[]>> certificates) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(providerAuthority);
        this.mProviderPackage = (String) Preconditions.checkNotNull(providerPackage);
        this.mQuery = (String) Preconditions.checkNotNull(query);
        this.mCertificates = (List) Preconditions.checkNotNull(certificates);
        this.mCertificatesArray = 0;
        StringBuilder sb = new StringBuilder(this.mProviderAuthority);
        String str = "-";
        sb.append(str);
        sb.append(this.mProviderPackage);
        sb.append(str);
        sb.append(this.mQuery);
        this.mIdentifier = sb.toString();
    }

    public FontRequest(@NonNull String providerAuthority, @NonNull String providerPackage, @NonNull String query, @ArrayRes int certificates) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(providerAuthority);
        this.mProviderPackage = (String) Preconditions.checkNotNull(providerPackage);
        this.mQuery = (String) Preconditions.checkNotNull(query);
        this.mCertificates = null;
        Preconditions.checkArgument(certificates != 0);
        this.mCertificatesArray = certificates;
        StringBuilder sb = new StringBuilder(this.mProviderAuthority);
        String str = "-";
        sb.append(str);
        sb.append(this.mProviderPackage);
        sb.append(str);
        sb.append(this.mQuery);
        this.mIdentifier = sb.toString();
    }

    @NonNull
    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    @NonNull
    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    @NonNull
    public String getQuery() {
        return this.mQuery;
    }

    @Nullable
    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    @ArrayRes
    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    @RestrictTo({Scope.LIBRARY_GROUP_PREFIX})
    public String getIdentifier() {
        return this.mIdentifier;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: ");
        sb.append(this.mProviderAuthority);
        sb.append(", mProviderPackage: ");
        sb.append(this.mProviderPackage);
        sb.append(", mQuery: ");
        sb.append(this.mQuery);
        sb.append(", mCertificates:");
        builder.append(sb.toString());
        for (int i = 0; i < this.mCertificates.size(); i++) {
            builder.append(" [");
            List<byte[]> set = (List) this.mCertificates.get(i);
            for (int j = 0; j < set.size(); j++) {
                builder.append(" \"");
                builder.append(Base64.encodeToString((byte[]) set.get(j), 0));
                builder.append("\"");
            }
            builder.append(" ]");
        }
        builder.append("}");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mCertificatesArray: ");
        sb2.append(this.mCertificatesArray);
        builder.append(sb2.toString());
        return builder.toString();
    }
}
