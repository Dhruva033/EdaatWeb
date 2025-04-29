package com.azmqalabs.edaattestautomation.common.uielement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import com.aventstack.extentreports.ExtentTest;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Locator {

	public static class ElementHandler implements MethodInterceptor {
		private final ElementLocator locator;
		private WebDriver webDriver = null;
		private Field field;
		private ExtentTest testReport = null;

		private static Set<String> ignoredMethods = new HashSet<String>() {
			{
				add("toString");
				add("hashCode");
			}
		};

		public ElementHandler(Field field, ElementLocator locator, WebDriver webDriver, ExtentTest test) {
			this.locator = locator;
			this.webDriver = webDriver;
			this.field = field;
			this.testReport = test;

		}

		private WebElement locateElement() {

			return locator.findElement();
		}

		private WebElement CustomlocateElement() {
			try {
				return locator.findElement();
			} catch (NoSuchElementException e) {
				return null;
			} catch (Exception e) {
				return null;
			}
		}

		// @Override
		public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

			if (ignoredMethods.contains(method.getName())) {
				return methodProxy.invokeSuper(o, objects);
			}
			if (o instanceof UIElement) {
				if (!method.getName().equals("setRootElement") && !method.getName().equals("setWebDriver")
						&& !method.getName().equals("setTest")) {
					UIElement comp = (UIElement) o;
					WebElement element;

					if (method.getName().equals("Exists"))
						element = CustomlocateElement();
					else
						element = locateElement();

					comp.setRootElement(element);
					comp.setWebDriver(webDriver);
					comp.setTest(testReport);
				}

				try {
					return methodProxy.invokeSuper(o, objects);
				} catch (InvocationTargetException e) {
					throw e.getCause();
				}

			} else if (o instanceof WebElement) {// only handle first displayed
				WebElement displayedElement = locateElement();

				if (displayedElement != null) {
					return method.invoke(displayedElement, objects);
				} else {
				}
			}

			return null;

		}

		@Override
		public String toString() {
			return "ElementHandler{" + "field=" + field + '}';
		}
	}

}
