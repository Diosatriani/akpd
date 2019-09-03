package com.bersama.aplikasiakpd.siswa;

public class SoalAngket {

    //Array Tentang Soal Angket
    public String pertanyaan[] = {
            "Saya kadang lupa bersyukur atas nikmat dan karunia dari Tuhan YME",
            "Saya kadang lupa untuk berprilaku sopan dan santun dalam kehidupan",
            "Saya merasa belum paham etika yang baik dan benar dalam pergaulan teman sebaya",
            "Saya merasa sulit mematuhi tata tertib di sekolah",
            "Kadang-kadang saya masih suka menyontek pada waktu ulangan",
            "Waktu saya banyak dihabiskan untuk bermain game atau games online",
            "Saya sulit meminta maaf jika melakukan kesalahan terhadap orang lain",
            "Saya masih merasa belum memiliki rasa percaya diri",
            "Saya belum tahu cara mengendalikan emosi ",
            "Kondisi keluarga saya sedang tidak harmonis",
            "Saya belum tahu cara melakukan eksplorasi bakat secara mandiri",
            "Saya masih sering mengalami sakit / alergi",
            "Kondisi keluarga saya sedang tidak harmonis",
            "Saya sedang mempunyai masalah dengan anggauta keluarga di rumah",
            "Saya merasa belum bisa menjadi pribadi yang mandiri",
            "Saya sering lupa waktu ketika bermain/membuka media sosial (fb, wa, instagram, dll)",
            "Saya merasa sulit mengendalikan ketergantungan dengan handphone",
            "Saya merasa tidak betah tinggal di rumah sendiri",
            "Saya merasa tidak pernah di perhatikan dari orang tua ",
            "Kata maaf, tolong dan terimakasih kadang lupa saya ucapkan dalam pergaulan",
            "Saya belum tahu tentang bentuk-bentuk kenakalan remaja saat ini dan cara mensikapinya",
            "Saya sering beda pendapat dengan orang lain",
            "Saya sedang mempunyai masalah dengan teman di sekolah",
            "Saya belum tahu cara untuk menjaga persahabatan agar tetap langgeng",
            "Saya belum tahu tentang bullying dan cara mensikapinya",
            "Saya sukar bergaul dengan teman-teman di sekolah",
            "Saya merasa masih sedikit pemahaman tentang kesehatan reproduksi remaja",
            "Saya belum banyak tahu tentang dampak dari pacaran",
            "Saya malu jika membicarakan masalah seks dan pacar kepada orang tua",
            "Saya merasa malu jika bergaul dengan teman yang beda jenis kelamin",
            "Saya merasa takut bertanya atau menjawab di kelas",
            "Saya belum paham yang harus dilakuan dengan adanya pemanasan global",
            "Saya belum mengetahui banyak tentang jenis obat-obat  terlarang serta dampaknya",
            "Saya belum tahu cara memilih lembaga bimbingan belajar",
            "Saya merasa tidak memiliki semangat belajar ",
            "Saya belum tahu cara meraih prestasi di sekolah",
            "Saya belum paham tentang gaya belajar dan strategi yang sesuai dengannya",
            "Saya merasa kesulitan dalam memahami pelajaran",
            "Saya belum terbiasa belajar bersama atau kelompok",
            "Saya merasa belum menenumkan cara belajar yang efektif",
            "Saya selalu malas untuk belajar di rumah",
            "Saya belajarnya jika akan ada ulangan atau ujian saja",
            "Orang tua kurang peduli dengan kegiatan belajar saya",
            "Saya belum bisa membuat peta pikiran (mind mapping)",
            "Saya belum mengenal tentang macam-macam kecerdasan",
            "Saya belum paham cara kerja otak kiri dan otak kanan ",
            "Saya sering dimarahi orang tua karena boros",
            "Saya tidak terbiasa menabung",
            "Saya kurang dapat menyalurkan bakat dan minat di sekolah",
            "Saya belum tahu tentang prospek karir untuk setiap mapel",
            "Saya belum banyak tahu tentang jenis-jenis profesi di masyarakat dan Prospeknya",
    };

    //array untuk jawaban
    private String pilihanJawaban[][]={
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
            {"Ya","Tidak"},
    };

    //membuat array untuk jawaban benar
    private String jawabanBenar[] = {
            "1","1","1","1","1","1","1","1","1","1",
            "1","1","1","1","1","1","1","1","1","1",
            "1","1","1","1","1","1","1","1","1","1",
            "1","1","1","1","1","1","1","1","1","1",
            "1","1","1","1","1","1","1","1","1","1",
    };

    //membuat getter untuk mengambil pertanyaan
    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    //membuat getter untuk mengambil pilihan jawaban 1
    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    //membuat getter untuk mengambil pilihan jawaban 2
    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }
    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }

}
