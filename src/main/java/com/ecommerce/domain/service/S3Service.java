package com.ecommerce.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.UUID;

@Service
public class S3Service {

    private final AmazonS3 amazonS3;

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    public S3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public String uploadBase64File(String base64File) {

        String fileName = UUID.randomUUID().toString() + ".jpg";

        // Decodificar Base64 a bytes
        byte[] decodedBytes = Base64.getDecoder().decode(base64File);

        // Crear InputStream a partir de los bytes decodificados
        ByteArrayInputStream inputStream = new ByteArrayInputStream(decodedBytes);

        // Crear solicitud de carga a S3
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, inputStream, null);

        // Subir el archivo a S3
        amazonS3.putObject(putObjectRequest);

        // Retornar URL del archivo subido
        return amazonS3.getUrl(bucketName, fileName).toString();
    }

    public InputStream downloadFile(String fileName) {
        S3Object s3Object = amazonS3.getObject(bucketName, fileName);
        return s3Object.getObjectContent();
    }

    public void deleteFile(String fileName) {
        amazonS3.deleteObject(bucketName, fileName);
    }
}
