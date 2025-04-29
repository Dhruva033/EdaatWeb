package com.azmqalabs.edaattestautomation.common.uielement;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import com.aventstack.extentreports.ExtentTest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class fieldDecorator implements FieldDecorator {
	final DefaultFieldDecorator defaultFieldDecorator;

	final SearchContext searchContext;
	private final WebDriver webDriver;
	private final ExtentTest testReport;

	public fieldDecorator(WebDriver webDriver, ExtentTest test) { // SearchContext searchContext, {
		this.searchContext = webDriver;
		this.webDriver = webDriver;
		this.testReport = test;
		defaultFieldDecorator = new DefaultFieldDecorator(new DefaultElementLocatorFactory(searchContext));
	}

	public Object getEnhancedObject(Class clzz, MethodInterceptor methodInterceptor) {
		Enhancer e = new Enhancer();
		e.setSuperclass(clzz);
		e.setCallback(methodInterceptor);
		return e.create();
	}

	public Object decorate(ClassLoader loader, Field field) {
		if (UIElement.class.isAssignableFrom(field.getType()) && field.isAnnotationPresent(FindBy.class)) {
			return getEnhancedObject(field.getType(), getElementHandler(field));
		} else {
			return defaultFieldDecorator.decorate(loader, field);
		}
	}

	private Locator.ElementHandler getElementHandler(Field field) {
		return new Locator.ElementHandler(field, getLocator(field), webDriver, testReport);
	}

	private ElementLocator getLocator(Field field) {
		return new DefaultElementLocatorFactory(searchContext).createLocator(field);
	}
}
