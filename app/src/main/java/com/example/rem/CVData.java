package com.example.rem;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.util.Optional;

public class CVData {
    private static final CVData instance = new CVData();
    private static final int DEFAULT_COMPRESSION_QUALITY = 80;
    private String fullName, email, phone, summary;
    private String education, experience, certifications, references;
    private String profileImageBase64;
    private CVData() {}
    public static CVData getInstance() {
        return instance;
    }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getFullName() { return fullName; }
    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPhone() { return phone; }
    public void setSummary(String summary) { this.summary = summary; }
    public String getSummary() { return summary; }
    public void setEducation(String education) { this.education = education; }
    public String getEducation() { return education; }
    public void setExperience(String experience) { this.experience = experience; }
    public String getExperience() { return experience; }
    public void setCertifications(String certifications) { this.certifications = certifications; }
    public String getCertifications() { return certifications; }
    public void setReferences(String references) { this.references = references; }
    public String getReferences() { return references; }
    public void setProfileImage(Bitmap bitmap) {
        Optional.ofNullable(bitmap).ifPresent(bmp -> {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG, DEFAULT_COMPRESSION_QUALITY, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            profileImageBase64 = Base64.encodeToString(byteArray, Base64.NO_WRAP);
        });
    }
    public String getProfileImageBase64() {
        return Optional.ofNullable(profileImageBase64).orElse("");
    }
    public Bitmap getProfileImageBitmap() {
        return Optional.ofNullable(profileImageBase64)
                .filter(s -> !s.isEmpty())
                .map(s -> Base64.decode(s, Base64.NO_WRAP))
                .map(bytes -> BitmapFactory.decodeByteArray(bytes, 0, bytes.length))
                .orElse(null);
    }
}