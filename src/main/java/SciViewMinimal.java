import cleargl.GLVector;
import io.scif.SCIFIOService;
import net.imagej.ImageJService;
import org.scijava.Context;
import org.scijava.service.SciJavaService;
import org.scijava.thread.ThreadService;
import org.scijava.ui.UIService;
import sc.iview.SciView;
import sc.iview.SciViewService;

/**
 * <Description>
 *
 * @author Ulrik Günther <hello@ulrik.is>
 */
public class SciViewMinimal {
  public static void main(String... args) {
    System.setProperty( "scijava.log.level:sc.iview", "debug" );
    Context context = new Context( ImageJService.class, SciJavaService.class, SCIFIOService.class, ThreadService.class);

    UIService ui = context.service( UIService.class );
    if( !ui.isVisible() ) ui.showUI();

    SciViewService sciViewService = context.service( SciViewService.class );
    SciView sciView = sciViewService.getOrCreateActiveSciView();
    sciView.getCamera().setPosition( new GLVector( 0.0f, 0.0f, 5.0f ) );
    sciView.getCamera().setTargeted( true );
    sciView.getCamera().setTarget( new GLVector( 0, 0, 0 ) );
    sciView.getCamera().setDirty( true );
    sciView.getCamera().setNeedsUpdate( true );
  }
}
