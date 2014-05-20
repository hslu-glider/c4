/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GameModel;

import java.util.*;

/**
 *
 * @author Jan
 */
public interface ModelListener 
{
    public void boardHasChanged(Chip[][] playBoard);
    public void playerHasChanged();
    public void winnIsSet();
}
