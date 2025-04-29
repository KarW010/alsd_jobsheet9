import java.util.Scanner;

public class SuratMain09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StackSurat09 stack = new StackSurat09(10);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat berdasarkan nama mahasiswa");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();
            switch (pilih) {
                case 1:
                    System.out.print("ID Surat     : ");
                    String id = scan.nextLine();
                    System.out.print("Nama Mahasiswa : ");
                    String nama = scan.nextLine();
                    System.out.print("Kelas        : ");
                    String kelas = scan.nextLine();
                    System.out.print("Jenis Izin (S/I): ");
                    char jenis = scan.next().toUpperCase().charAt(0);
                    System.out.print("Durasi (hari)  : ");
                    int durasi = scan.nextInt();
                    scan.nextLine();
                    Surat09 surat = new Surat09(id, nama, kelas, jenis, durasi);
                    stack.push(surat);
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("Tidak ada surat yang perlu diproses.");
                    } else {
                        System.out.println("Memproses semua surat izin...");
                        while (!stack.isEmpty()) {
                            Surat09 srt = stack.pop();
                            String jenisIzinStr = srt.jenisIzin == 'S' ? "Sakit" : "Izin Keperluan Lain";
                            System.out.println(srt.namaMahasiswa + " (" + srt.kelas + "), Jenis: " + jenisIzinStr + 
                            ", Durasi: " + srt.durasi + " hari.");
                        }
                    }
                    break;
                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack kosong. Belum ada surat yang dimasukkan.");
                    } else {
                        Surat09 terakhir = stack.peek();
                        System.out.println("Surat terakhir dari: " + terakhir.namaMahasiswa + " (" + terakhir.idSurat + ")");
                    }
                    break;
                case 4:
                    System.out.print("Masukkan nama mahasiswa: ");
                    String cariNama = scan.nextLine();
                    stack.searchByNama(cariNama);
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (pilih >= 1 && pilih <= 4);
    }
}
