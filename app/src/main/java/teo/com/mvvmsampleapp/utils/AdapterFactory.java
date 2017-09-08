package teo.com.mvvmsampleapp.utils;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Factory class to help with the deserialization of Parcelable objects
 * made with AutoValue, so that you don't have to add each generated
 * TypeAdapter to your Gson instance manually.
 * @see : <a href="https://github.com/rharter/auto-value-gson/blob/master/README.md#factory">documentation</a>
 */

@GsonTypeAdapterFactory
public abstract class AdapterFactory implements TypeAdapterFactory {

    public static AdapterFactory create() {
        return new AutoValueGson_AdapterFactory();
    }
}