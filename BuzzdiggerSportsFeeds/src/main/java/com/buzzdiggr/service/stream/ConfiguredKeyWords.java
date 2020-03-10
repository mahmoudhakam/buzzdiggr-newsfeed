package com.buzzdiggr.service.stream;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

/**
 * This class simulates the configured favored topics for certain user
 * 
 */

@Service
public class ConfiguredKeyWords
{
	private Set<String> userFavouredToics = new HashSet<String>();

	@PostConstruct
	void init()
	{
		userFavouredToics.add("ريال مدريد");
		userFavouredToics.add("الزمالك");
		userFavouredToics.add("الأهلى");
		userFavouredToics.add("برشلونة");
		userFavouredToics.add("محمد صلاح");
		userFavouredToics.add("كريستيانو");
		userFavouredToics.add("ميسى");
		userFavouredToics.add("الترجى");
		userFavouredToics.add("كأس السوبر");
		userFavouredToics.add("الدورى المصرى");
		userFavouredToics.add("الخطيب");
		userFavouredToics.add("الكأس");
		userFavouredToics.add("رياضة");
		userFavouredToics.add("الرياضة");
		userFavouredToics.add("كرة القدم");
		userFavouredToics.add("كرة السلة");
		userFavouredToics.add("ركلة جزاء");
		userFavouredToics.add("كوسنجو");
		userFavouredToics.add("تصفيات");
		userFavouredToics.add("نهائى");
		userFavouredToics.add("ضربات جزاء");
		userFavouredToics.add("ميدالية");
		userFavouredToics.add("منتخب");
		userFavouredToics.add("اسماعيلى");
		userFavouredToics.add("بيراميدز");
		userFavouredToics.add("إتحاد");
		userFavouredToics.add("كاف");
		userFavouredToics.add("القلعة البيضاء");
		userFavouredToics.add("القلعة الحمراء");
		userFavouredToics.add("الدراويش");
		userFavouredToics.add("الملعب");
		userFavouredToics.add("ليفربول");
		userFavouredToics.add("أندية");
		userFavouredToics.add("منتخبات");
		userFavouredToics.add("تريزيجيه");
		userFavouredToics.add("مباريات");
		userFavouredToics.add("أمم أفريقيا");
		userFavouredToics.add("رياضة");
		userFavouredToics.add("أليسون");
		userFavouredToics.add("كلوب");
		userFavouredToics.add("كأس العالم");
		userFavouredToics.add("البرازيل");
		userFavouredToics.add("الترجى");
		userFavouredToics.add("فوز");
		userFavouredToics.add("هزيمة");
		userFavouredToics.add("الدورى الإنجليزى");
		userFavouredToics.add("المرمى");
		userFavouredToics.add("الكونفدرالية");
		userFavouredToics.add("أهداف");
		userFavouredToics.add("هدف");
		userFavouredToics.add("الريمونتادا");
		userFavouredToics.add("التنس");
		userFavouredToics.add("كرة الطائرة");
		userFavouredToics.add("أسكواش");
		userFavouredToics.add("اليوفتس");
		userFavouredToics.add("ميلان");
	}

	public Set<String> getUserFavouredToics()
	{
		return userFavouredToics;
	}
}
