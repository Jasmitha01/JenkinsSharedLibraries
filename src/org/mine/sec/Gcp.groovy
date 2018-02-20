import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class Gcp {
  public static void main(String... args) throws Exception {
    // Instantiates a client
    Storage storage = StorageOptions.getDefaultInstance().getService();

    // The name for the new bucket
    String bucketName = "my-new-bucket";  // "my-new-bucket";

    // Creates the new bucket
    Bucket bucket = storage.create(BucketInfo.of(bucketName));

    println "Bucket %s created.%n", bucket.getName()";
  }
}
