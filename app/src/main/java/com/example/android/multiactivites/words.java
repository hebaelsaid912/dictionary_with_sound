package com.example.android.multiactivites;

public class words {

   private String mDefualtTranslation;
    private String mMiwokTranslation;
    private int mMiwokImageResourses=has_no_source_image;
    private static final int has_no_source_image=0;
    private int mMiwokSoundResourses=0;

    public words(String mDefualtTranslation , String mMiwokTranslation , int mMiwokImageResourses , int mMiwokSoundResourses){
        this.mDefualtTranslation = mDefualtTranslation;
        this.mMiwokTranslation =  mMiwokTranslation;
        this.mMiwokImageResourses =  mMiwokImageResourses;
        this.mMiwokSoundResourses = mMiwokSoundResourses;
    }

    public String getmDefualtTranslation() {
        return mDefualtTranslation;
    }

    public void setmDefualtTranslation(String mDefualtTranslation) {
        this.mDefualtTranslation = mDefualtTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public void setmMiwokTranslation(String mMiwokTranslation) {
        this.mMiwokTranslation = mMiwokTranslation;
    }

    public int getmMiwokImageResourses() { return mMiwokImageResourses; }

    public void setmMiwokImageResourses(int mMiwokImageResourses) {
        this.mMiwokImageResourses = mMiwokImageResourses;
    }
    public boolean hasNOImage(){
        return mMiwokImageResourses != has_no_source_image ;
    }
    public int getmMiwokSoundResourses() {
        return mMiwokSoundResourses;
    }

    public void setmMiwokSoundResourses(int mMiwokSoundResourses) {
        this.mMiwokSoundResourses = mMiwokSoundResourses;
    }
}
