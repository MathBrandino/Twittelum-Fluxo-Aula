package br.com.caelum.twittelumfluxoaula.bancodedados.conversor;

import android.arch.persistence.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class LocalDateTimeConverter {

    @TypeConverter
    public static Long converte(LocalDateTime horario) {

        Instant instant = horario.toInstant(ZoneOffset.UTC);

        return instant.getEpochSecond();

    }


    @TypeConverter
    public static LocalDateTime converte(Long horario) {

        return LocalDateTime.ofInstant(Instant.ofEpochSecond(horario), ZoneOffset.UTC);
    }

}
