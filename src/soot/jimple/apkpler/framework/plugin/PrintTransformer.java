package soot.jimple.apkpler.framework.plugin;

import soot.Body;
import soot.jimple.apkpler.interf.DefaultPlugin;

public class PrintTransformer extends DefaultPlugin 
{

	public PrintTransformer(String name) 
	{
		super(name);
	}

	@Override
	public void bodyTransform(Body body) 
	{
		String clsName = body.getMethod().getDeclaringClass().getName();
		
		if (clsName.startsWith("android.support.v") || 
				clsName.endsWith("BuildConfig") || 
				clsName.endsWith(".R") ||
				clsName.contains(".R$"))
		{
			return;
		}
		
		
		System.out.println(body.toString());
	}
	
}
