# KPI → Tammi V1

Luồng PA A:
1. WorkManager chạy hằng ngày (mặc định 07:30, người dùng chỉnh được).
2. Tải file ZIP từ URL đã cấu hình.
3. Kiểm tra chữ ký ZIP `PK`.
4. Giải nén an toàn (chặn Zip Slip).
5. Lọc file gửi: PNG/JPG/PDF/XLS/XLSX/CSV/DOCX; bỏ `__MACOSX`, file ẩn.
6. Thông báo "Báo cáo KPI đã sẵn sàng".
7. Bấm `GỬI TAMMI` để mở Android Share Sheet và gửi toàn bộ file đã giải nén.
8. Xóa thư mục báo cáo cũ hơn 3 ngày.

## Ghi chú quan trọng
- Đây là PA A nên Android không tự bấm nút Gửi bên trong Tammi.
- Cần URL tải trực tiếp file ZIP. Link phải trả về bytes ZIP, không phải trang HTML đăng nhập.
- Nếu biết package name chính thức của Tammi, có thể thêm `intent.setPackage("...")` trong MainActivity để mở thẳng Tammi.
- File lưu trong external app-specific storage nên không cần quyền READ/WRITE_EXTERNAL_STORAGE.

## Build APK trên GitHub Actions
Source đã có workflow `.github/workflows/build-apk.yml`.

- Push lên `main` hoặc `master` sẽ tự build `assembleDebug`.
- Có thể chạy thủ công tại **Actions → Build KPI Tammi APK → Run workflow**.
- APK nằm trong **Artifacts → KPI-Tammi-AutoShare-V1-APK**.
- Workflow tự cài **JDK 17 + Gradle 8.9**, không cần Gradle Wrapper trong repo.
