## Hotel Booking System

### 📁 Repository: `hotel-booking-api`

### 🎯 Product Requirement:

Sistem reservasi kamar hotel oleh pelanggan.

### 📡 Endpoint (Minimal 8):

| Method | Endpoint                   | Description                   |
| ------ | -------------------------- | ----------------------------- |
| POST   | `/rooms`                   | Tambah kamar                  |
| GET    | `/rooms`                   | Lihat semua kamar             |
| POST   | `/bookings`                | Buat booking                  |
| GET    | `/bookings`                | List booking (filter by date) |
| GET    | `/bookings/{id}`           | Detail booking                |
| PUT    | `/bookings/{id}`           | Ubah tanggal booking          |
| DELETE | `/bookings/{id}`           | Batalkan booking              |
| GET    | `/rooms/{id}/availability` | Cek ketersediaan kamar        |

### 🧪 Validasi:

- `@NotBlank` → customer name
- `@Future` → check-in/check-out
- Custom: `check_in < check_out`
