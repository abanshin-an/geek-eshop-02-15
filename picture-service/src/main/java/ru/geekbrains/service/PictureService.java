package ru.geekbrains.service;

import ru.geekbrains.service.PictureDto;

import java.util.List;
import java.util.Optional;

public interface PictureService {

    Optional<PictureDto> getPictureDataById(long id);

    String createPicture(byte[] pictureData);

    List<Long> listPictures();
}
