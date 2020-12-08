package com.itisacat.agent.demo;

import com.sun.tools.attach.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException, AgentLoadException, AgentInitializationException, AttachNotSupportedException {
		//获取当前系统中所有 运行中的 虚拟机
		System.out.println("running JVM start ");
		List<VirtualMachineDescriptor> list = VirtualMachine.list();
		for (VirtualMachineDescriptor vmd : list) {
			//如果虚拟机的名称为 xxx 则 该虚拟机为目标虚拟机，获取该虚拟机的 pid
			//然后加载 agent.jar 发送给该虚拟机
			System.out.println(vmd.displayName());
			if (vmd.displayName().endsWith("com.itisacat.agent.demo.DemoApplication")) {
				VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
				virtualMachine.loadAgent("/Users/gaoqiuling/Desktop/demo/agent.jar");
				virtualMachine.detach();
			}
		}
	}

}
