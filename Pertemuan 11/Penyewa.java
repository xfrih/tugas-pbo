class Penyewa {
    private String nama;
    private Kendaraan kendaraan;

    public Penyewa(String nama, Kendaraan kendaraan) {
        this.nama = nama;
        this.kendaraan = kendaraan;
    }

    public String getDetailSewa() {
        return "\n[Penyewa]\n\t" + nama + "\n[Detail Rental]\n" + kendaraan.getInfo() + "\n";
    }
}
