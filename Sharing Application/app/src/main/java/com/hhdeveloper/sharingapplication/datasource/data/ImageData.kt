package com.hhdeveloper.sharingapplication.datasource.data

import android.net.Uri

data class ImageData(
        override val uri: Uri,
        override val idIndex:Long,//cursor.getColumnIndex(MediaStore.Images.Media._ID);
        override val dateIndex:String,//cursor.getColumnIndex(MediaStore.Images.Media.DATE_ADDED);
        override val sizeIndex:String,//cursor.getColumnIndex(MediaStore.Images.Media.SIZE);
        override val typeIndex:String,//cursor.getColumnIndex(MediaStore.Images.Media.MIME_TYPE);
        override val folderIndex:String,//cursor.getColumnIndex(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
        val titleIndex:String,//cursor.getColumnIndex(MediaStore.Images.Media.TITLE);
        val displayIndex:String,//cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME);
):MediaData
