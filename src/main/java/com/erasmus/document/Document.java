package com.erasmus.document;

import java.time.LocalDate;

public class Document {
    private String documentId;
    private String userId;
    private String fileName;
    private String fileType;
    private String category;
    private LocalDate uploadDate;
    private LocalDate deadline;
    private String description;
    private String filePath;

    private Document(DocumentBuilder builder) {
        this.documentId = builder.documentId;
        this.userId = builder.userId;
        this.fileName = builder.fileName;
        this.fileType = builder.fileType;
        this.category = builder.category;
        this.uploadDate = builder.uploadDate;
        this.deadline = builder.deadline;
        this.description = builder.description;
        this.filePath = builder.filePath;
    }

    public String getDocumentId() { return documentId; }
    public String getUserId() { return userId; }
    public String getFileName() { return fileName; }
    public String getFileType() { return fileType; }
    public String getCategory() { return category; }
    public LocalDate getUploadDate() { return uploadDate; }
    public LocalDate getDeadline() { return deadline; }
    public String getDescription() { return description; }
    public String getFilePath() { return filePath; }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + documentId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", category='" + category + '\'' +
                ", deadline=" + deadline +
                '}';
    }

    public static class DocumentBuilder {
        private String documentId;
        private String userId;
        private String fileName;
        private String fileType;
        private String category;
        private LocalDate uploadDate;
        private LocalDate deadline;
        private String description;
        private String filePath;

        public DocumentBuilder(String documentId, String userId, String fileName) {
            this.documentId = documentId;
            this.userId = userId;
            this.fileName = fileName;
            this.uploadDate = LocalDate.now();
        }

        public DocumentBuilder fileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public DocumentBuilder category(String category) {
            this.category = category;
            return this;
        }

        public DocumentBuilder deadline(LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        public DocumentBuilder description(String description) {
            this.description = description;
            return this;
        }

        public DocumentBuilder filePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public Document build() {
            return new Document(this);
        }
    }
}
