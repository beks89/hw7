package ru.netology.attachments

data class PhotoAttachment(val photo: Photo, override val type: String = "photo") : Attachment
data class VideoAttachment(val video: Video, override val type: String = "video") : Attachment
data class AudioAttachment(val audio: Audio, override val type: String = "audio") : Attachment
data class LinkAttachment(val link: Link, override val type: String = "link") : Attachment
data class NoteAttachment(val note: Note, override val type: String = "note") : Attachment
data class AbsentAttachments(override val type: String = "Вложения Отсутствуют") : Attachment