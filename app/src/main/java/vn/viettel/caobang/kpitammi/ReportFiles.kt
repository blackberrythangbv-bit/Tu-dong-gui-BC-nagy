package vn.viettel.caobang.kpitammi

import android.content.Context
import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object ReportFiles {
    private val fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    fun today(): String = LocalDate.now().format(fmt)
    fun baseDir(context: Context) = File(context.getExternalFilesDir(null), "reports")
    fun dayDir(context: Context) = File(baseDir(context), today()).apply { mkdirs() }
    fun extractedDir(context: Context) = File(dayDir(context), "extracted").apply { mkdirs() }
    fun latestExtractedDir(context: Context): File? = baseDir(context).listFiles()?.filter { it.isDirectory }?.maxByOrNull { it.lastModified() }?.let { File(it,"extracted") }
    fun allowed(file: File): Boolean {
        if (file.name.startsWith(".")) return false
        val path = file.absolutePath.lowercase()
        if (path.contains("__macosx")) return false
        return file.extension.lowercase() in setOf("png","jpg","jpeg","pdf","xlsx","xls","csv","docx")
    }
}
