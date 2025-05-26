package Programa;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.List;

/* 
 * Classe criada para organizar a ordem de foco utilizada no mainFrame
*/
public class CustomFocusTraversalPolicy extends FocusTraversalPolicy {

  private final List<Component> components;

  public CustomFocusTraversalPolicy(List<Component> components) {
    this.components = components;
  }

  @Override
  public Component getComponentAfter(Container container, Component component) {
    int index = components.indexOf(component);
    int nextIndex = (index + 1) % components.size();
    return components.get(nextIndex);
  }

  @Override
  public Component getComponentBefore(Container container, Component component) {
    int index = components.indexOf(component);
    int previousIndex = (index - 1 + components.size()) % components.size();
    return components.get(previousIndex);
  }

  @Override
  public Component getFirstComponent(Container container) {
    return components.get(0);
  }

  @Override
  public Component getLastComponent(Container container) {
    return components.get(components.size() - 1);
  }

  @Override
  public Component getDefaultComponent(Container container) {
    try {
      return components.get(0);
    }
    catch(Exception ex){
      return null;
    }
  }
  
}
